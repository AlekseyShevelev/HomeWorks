package task1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Course course = new Course("Математика", 240);
        System.out.println("New Course object: " + course);

        addCourse(course);

        Course retrievedCourse = getCourse(course.getId());
        System.out.println("Retrieved Course object: " + retrievedCourse);

        course.setDuration(480);
        updateCourse(course);
        retrievedCourse = getCourse(course.getId());
        System.out.println("Retrieved Course object: " + retrievedCourse);

        deleteCourse(retrievedCourse);
    }

    private static void addCourse(Course course) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Object Course saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Course getCourse(int id) {
        Course course = null;

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            course = session.get(Course.class, id);
            session.getTransaction().commit();
            System.out.println("Object Course retrieved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }

    private static void updateCourse(Course course) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
            System.out.println("Object Course updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteCourse(Course course) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Object Course deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
