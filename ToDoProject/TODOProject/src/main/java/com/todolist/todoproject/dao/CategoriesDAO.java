package com.todolist.todoproject.dao;

import com.todolist.todoproject.components.DataBase;
import com.todolist.todoproject.model.Categories;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.todolist.todoproject.config.constants.DB_TABLE_CATEGORIES;

@Service
public class CategoriesDAO {

    public Boolean createCategory(Categories category) {
        String dateCreate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String query = String.format("INSERT INTO %s (category, date_create) VALUES ('%s','%s');",
                DB_TABLE_CATEGORIES, category.getCategory(), dateCreate);
        return DataBase.statementExecute(query);
    }

    public Boolean editCategory(Categories category) {
        String dateUpdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        return DataBase.statementExecute(String.format("UPDATE %s SET category='%s', date_update='%s' WHERE id=%d;",
                DB_TABLE_CATEGORIES, category.getCategory(), dateUpdate, category.getId()));
    }
}
