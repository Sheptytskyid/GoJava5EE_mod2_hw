package jdbchomework;

import jdbchomework.dao.hibernate.*;
import jdbchomework.entity.*;
import jdbchomework.utils.HibernateUtil;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
//        ProjectsDao projectsDao = new ProjectsHibDao("Project",
//                HibernateUtil.getSessionFactory(), Project.class);
//
//        SkillsDao skillsDao = new SkillsHibDao("Skill",
//                HibernateUtil.getSessionFactory(), Skill.class);
//
//        CustomersDao customersDao = new CustomersHibDao("Customer",
//                HibernateUtil.getSessionFactory(), Customer.class);
//
//        DevelopersDao developersDao = new DevelopersHibDao("Developer",
//                HibernateUtil.getSessionFactory(), Developer.class);

        CompaniesHibDao companiesDao = new CompaniesHibDao("Company",
                HibernateUtil.getSessionFactory(), Company.class);
//        System.out.println(companiesDao.getById(1));

//        List<Developer> list=companiesDao.getDeveloper(1);
//        for (Developer developer : list) {
//            System.out.println("=============");
//            System.out.println(developer);
//            System.out.println("=============");
//        }
        List<Developer> list = companiesDao.getCompanyDevelopers(1);

        for (Developer developer : list) {
            System.out.println("=============");
            System.out.println(developer);
            System.out.println("=============");
        }
        HibernateUtil.closeFactory();


    }
}
