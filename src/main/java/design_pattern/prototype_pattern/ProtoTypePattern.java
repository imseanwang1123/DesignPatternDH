package design_pattern.prototype_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class ProtoTypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {

        Resume resume1 = new Resume("sean");
        resume1.setPersonInfo("male", 30);
        resume1.setWorkExperience(new WorkExperience("2019/01/01", "google"));

        Resume resume2 = resume1.clone();
        resume2.setWorkExperience(new WorkExperience("2020/01/01", "apple"));

        Resume resume3 = resume1.clone();
        resume3.setWorkExperience(new WorkExperience("2021/01/01", "facebook"));

        resume1.display();
        resume2.display();
        resume3.display();
    }

    @Getter
    @RequiredArgsConstructor
    public static class Resume implements Cloneable {
        private final String name;
        private String sex;
        private int age;
        @Setter
        private WorkExperience workExperience;

        public void setPersonInfo(String sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        public void display() {
            System.out.println(name + ", " + sex + ", " + age);
            System.out.println("工作經歷 : " + workExperience.workDate + " " + workExperience.company);
        }

        @Override
        protected Resume clone() throws CloneNotSupportedException {
            return (Resume) super.clone();
        }

    }

    @AllArgsConstructor
    @Getter
    public static class WorkExperience implements Cloneable {
        private String workDate;
        private String company;

        @Override
        protected WorkExperience clone() throws CloneNotSupportedException {
            return (WorkExperience) super.clone();
        }
    }
}
