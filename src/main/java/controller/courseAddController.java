package controller;

import model.courseAddModel;
import databaseAccessLayer.courseAddAccessLogic;

public class courseAddController {

    courseAddModel objCourse;
    courseAddAccessLogic bal;

    public courseAddController() {
        bal = new courseAddAccessLogic();

    }

    public courseAddModel addCourse(String utype) {
        objCourse = new courseAddModel(utype);
        return objCourse;
    }

    public boolean insertCourseToDB(courseAddModel course) {
        boolean result = bal.addCourseTODB(course);
        return result;
    }

    public boolean updateCourseToDB(String course, int id) {
        boolean result = bal.updateCourseToDB(course, id);
        return result;
    }

    public boolean deleteCourseToDB(int id) {
        boolean result = bal.deleteCourseToDB(id);
        return result;
    }
}
