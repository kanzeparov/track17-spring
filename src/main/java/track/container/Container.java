package track.container;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import track.container.config.Bean;
import track.container.config.InvalidConfigurationException;
import track.container.config.Property;
import track.container.config.ValueType;

/**
 * Основной класс контейнера
 * У него определено 2 публичных метода, можете дописывать свои методы и конструкторы
 */
public class Container {

    private Map<String, Object> objByName;
    private Map<String, Object> objByClassName;
    private List<Bean> beans;
    private Property currentProperty; // Проверка на цикличность

    // Реализуйте этот конструктор, используется в тестах!
    public Container(List<Bean> beans) throws InvalidConfigurationException {
        currentProperty = null;
        objByName = new HashMap<>();
        objByClassName = new HashMap<>();
        this.beans = beans;

    }

    private Object createObject(Bean bean) throws InvalidConfigurationException {
        try {
            String className = bean.getClassName();
            Class clazz = Class.forName(className);
            Object instance = clazz.newInstance();
            String idName = bean.getId();
            objByName.put(idName, instance);
            objByClassName.put(className, objByName.get(idName));
            Object current = getById(bean.getId());
            Class currentClazz = current.getClass();
            for (Property property : bean.getProperties().values()) {
                if (currentProperty == property) {
                    throw new InvalidConfigurationException("циклическая зависимость");
                }
                String name = property.getName();
                Field field = currentClazz.getDeclaredField(name.toString());
                Method method = currentClazz.getDeclaredMethod(setSetterName(name), field.getType());
                method.setAccessible(true);

                if (property.getType().equals(ValueType.VAL)) {
                    method.invoke(current, Integer.parseInt(property.getValue()));
                    currentProperty = null;
                } else {
                    method.invoke(current, getByClass(field.getType().getTypeName()));
                    currentProperty = property;
                }
            }

            return current;
        } catch (Exception e) {
            throw new InvalidConfigurationException(e.getMessage());
        }
    }



    private String setSetterName(String nameValue) {
        nameValue = new String("set" + (nameValue.substring(0, 1).toUpperCase() + nameValue.substring(1)));
        return nameValue;
    }


    /**
     * Вернуть объект по имени бина из конфига
     * Например, Car car = (Car) container.getById("carBean")
     */
    public Object getById(String id) throws InvalidConfigurationException {
        if (objByName.containsKey(id)) {
            return objByName.get(id);
        } else {
            for (Bean bean : beans) {
                if (bean.getId().equals(id)) {
                    return createObject(bean);
                }
            }
            return null;
        }
    }

    /**
     * Вернуть объект по имени класса
     * Например, Car car = (Car) container.getByClass("track.container.beans.Car")
     */
    public Object getByClass(String className) throws InvalidConfigurationException {
        if (objByClassName.containsKey(className)) {
            return objByClassName.get(className);
        } else {
            for (Bean bean : beans) {
                if (bean.getClassName().equals(className)) {
                    return createObject(bean);
                }
            }
            return null;
        }
    }
}