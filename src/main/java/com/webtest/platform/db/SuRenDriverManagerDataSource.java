package com.webtest.platform.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.sqlite.Function;
import org.sqlite.SQLiteConnection;

/**
 * 扩展数据库连接
 * @author 
 * @date 
 */
public class SuRenDriverManagerDataSource extends DriverManagerDataSource
{

	@Override
	protected Connection getConnectionFromDriver(Properties props)
			throws SQLException
	{
		Connection conn = super.getConnectionFromDriver(props);
		
		if(conn instanceof SQLiteConnection)
		{
			createUserDefFunc4SQLite(conn);
		}
		
		return conn;
	}
	
	/**
	 * 为SQLite数据库添加自定义函数
	 * @param conn
	 * @throws SQLException
	 */
	private void createUserDefFunc4SQLite(Connection conn) throws SQLException
	{
		Function.create(conn, "UUID", new Function() {
			@Override
			protected void xFunc() {
				try
				{
					this.result(UUID.randomUUID().toString());
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
	    });
		Function.create(conn, "left", new Function() {
			@Override
			protected void xFunc() {
				try
				{
					String str = this.value_text(0);
					int len = this.value_int(1);
					
					if(str.length() > len)
					{
						this.result(str.substring(0, len));
					}
					else
					{
						this.result(str);
					}
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
	    });
	}

}

