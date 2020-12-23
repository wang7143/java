package BaseDao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.jdbcutils;

public abstract class Dao<T> {

    private Class<T> clazz = null;

    {
        Type cla = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) cla;
        Type[] actual = type.getActualTypeArguments();
        clazz = (Class<T>) actual[0];
    }

    public void update(Connection con,String sql,Object ...args) {
        // Connection con = jdbcutils.get();
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1, args[i]);
            }
            pr.execute();
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally{
            jdbcutils.closeresource(null, pr);
        }
    }

    public T get(Connection con, String sql, Object... args) {
        PreparedStatement pre = null;
        ResultSet ex = null;
        try {
            pre = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            ex = pre.executeQuery();

            ResultSetMetaData meta = ex.getMetaData();
            int col = meta.getColumnCount();
            if (ex.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < col; i++) {
                    Object ob = ex.getObject(i + 1);
                    // 通过下面方法获取的列名 getColumnName()
                    // 获取别名 getColumnLabel(),针对类字段名和表字段名不一样的情况
                    String name = meta.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t, ob);
                }
                return t;
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(null, pre, ex);
        }

        return null;
    }

    public List<T> getmut(Connection con,String sql,Object...args) {
        PreparedStatement pre = null;
        ResultSet ex = null;
        try {
            pre = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1, args[i]);
            }
            ex = pre.executeQuery();

            ResultSetMetaData meta = ex.getMetaData();
            int col = meta.getColumnCount();
            //创建集和储存对象
            ArrayList<T> list = new ArrayList<T>();
            while(ex.next()){
                T t = clazz.getDeclaredConstructor().newInstance();
                for (int i = 0; i < col; i++) {
                    Object ob = ex.getObject(i +1);
                    //通过下面方法获取的列名 getColumnName()
                    //获取别名 getColumnLabel(),针对类字段名和表字段名不一样的情况
                    String name = meta.getColumnLabel(i+1);
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,ob);
                }
                list.add(t);
            }
            return list;
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }finally{
            jdbcutils.closeresource(null, pre, ex);
        }

        return null;
    }

    public <E>E getValue(Connection con,String sql,Object...args) {
        PreparedStatement pr = null;
        ResultSet ex = null;
        try {
            pr = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1, args[i]);
            }
            ex = pr.executeQuery();
            if(ex.next()){
                return (E) ex.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            jdbcutils.closeresource(null, pr, ex);
        }
        return null;
    }

}
