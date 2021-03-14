package design_pattern.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class Decorator {
    public static void main(String[] args) {

        Sword sword = new Sword();
        Warrior warrior = new Warrior("sean", sword);
        warrior.attack();
        FirePower firePower = new FirePower(sword);
        warrior.changeWeapon(firePower);
        warrior.attack();
        HolyPower holyPower = new HolyPower(firePower);
        warrior.changeWeapon(holyPower);
        warrior.attack();
    }

    public interface Weapon {
        String getName();

        int getHitPoint();

        void attack();
    }

    public static class Sword implements Weapon {

        @Override
        public String getName() {
            return "劍";
        }

        @Override
        public int getHitPoint() {
            return 10;
        }

        @Override
        public void attack() {
            System.out.println(getName() + "造成" + getHitPoint() + "傷害");
        }
    }

    @AllArgsConstructor
    public static abstract class WeaponDecorator implements Weapon {
        private String name;
        private int hitPoint;
        @Getter
        private Weapon weapon;

        @Override
        public String getName() {
            return this.name + this.weapon.getName();
        }

        @Override
        public int getHitPoint() {
            return this.hitPoint + weapon.getHitPoint();
        }

        @Override
        public void attack() {
            System.out.println(getName() + "造成" + (hitPoint + weapon.getHitPoint()) + "點傷害");
            this.special();
        }

        protected void special() {
            if (weapon instanceof WeaponDecorator) {
                ((WeaponDecorator) weapon).special();
            }
        }
    }

    public static class FirePower extends WeaponDecorator {
        public FirePower(Weapon weapon) {
            super("火", 10, weapon);
        }

        @Override
        protected void special() {
            super.special();
            System.out.println("特殊效果:火焰造成 10點傷害");
        }
    }

    public static class HolyPower extends WeaponDecorator {
        public HolyPower(Weapon weapon) {
            super("聖", 5, weapon);
        }

        @Override
        protected void special() {
            super.special();
            System.out.println("特殊效果:回復5點HP");
        }
    }

    @AllArgsConstructor
    public static class Warrior {
        private String name;
        private Weapon weapon;

        public void attack() {
            System.out.print(this.name + "使用");
            weapon.attack();
            System.out.println("\n");
        }

        public void changeWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

    }
}
