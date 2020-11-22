package ua.lviv.iot.businesslogic.transformer;

import ua.lviv.iot.businesslogic.model.annotations.Column;
import ua.lviv.iot.businesslogic.model.annotations.PrimaryKeyComposite;
import ua.lviv.iot.businesslogic.model.annotations.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transformer<T> {
    private final Class<T> clazz;

    public Transformer(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Object extractDataToModel(ResultSet rs) throws SQLException {
        Object entity = null;
        try {
            entity = clazz.getConstructor().newInstance();
            if (clazz.isAnnotationPresent(Table.class)) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Column.class)) {
                        Column column = field.getAnnotation(Column.class);
                        String name = column.name();
                        String type = column.type();
                        field.setAccessible(true);
                        switch (type) {
                            case "string":
                                field.set(entity, rs.getString(name));
                                break;
                            case "int":
                                field.set(entity, rs.getInt(name));
                                break;
                            case "bool":
                                field.set(entity, rs.getBoolean(name));
                                break;
                            case "boolean":
                                field.set(entity, rs.getBoolean(name));
                                break;
                            case "double":
                                field.set(entity, rs.getDouble(name));
                                break;
                            default:
                                break;
                        }
                    } else if (field.isAnnotationPresent(PrimaryKeyComposite.class)) {
                        field.setAccessible(true);
                        Class fieldType = field.getType();
                        Object FK = fieldType.getConstructor().newInstance();
                        field.set(entity, FK);
                        Field[] fieldsInner = fieldType.getDeclaredFields();
                        for (Field fieldInner : fieldsInner) {
                            if (fieldInner.isAnnotationPresent(Column.class)) {
                                Column column = (Column) fieldInner.getAnnotation(Column.class);
                                String name = column.name();
                                String type = column.type();
                                fieldInner.setAccessible(true);
                                switch (type) {
                                    case "string":
                                        fieldInner.set(FK, rs.getString(name));
                                        break;
                                    case "int":
                                        fieldInner.set(FK, rs.getInt(name));
                                        break;
                                    case "bool":
                                        fieldInner.set(FK, rs.getBoolean(name));
                                        break;
                                    case "boolean":
                                        fieldInner.set(FK, rs.getBoolean(name));
                                        break;
                                    case "double":
                                        fieldInner.set(FK, rs.getDouble(name));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }

                    }
                }
            }

            } catch(InstantiationException | IllegalAccessException | NoSuchMethodException
                    | InvocationTargetException ignored){
                System.out.println("can't transform object");
            }

            return entity;
        }
    }