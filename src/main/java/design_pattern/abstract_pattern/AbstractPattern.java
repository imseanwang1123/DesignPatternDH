package design_pattern.abstract_pattern;

public class AbstractPattern {

    interface Warrior {
        void swordAttack();
    }

    public static class IceWarrior implements Warrior {

        @Override
        public void swordAttack() {
            System.out.println("Use ice sword to attack");
        }
    }

    public static class FireWarrior implements Warrior {
        @Override
        public void swordAttack() {
            System.out.println("Use fire sword to attack");
        }
    }

    interface Magician {
        void magicAttack();
    }

    public static class IceMagician implements Magician {

        @Override
        public void magicAttack() {
            System.out.println("Use ice ball to attack");
        }
    }

    public static class FireMagician implements Magician {

        @Override
        public void magicAttack() {
            System.out.println("Use fire ball to attack");
        }
    }

    interface HeroFactory {
        Warrior makeWarrior();

        Magician makeMagician();
    }

    public static class IceHeroFactory implements HeroFactory {

        @Override
        public Warrior makeWarrior() {
            return new IceWarrior();
        }

        @Override
        public Magician makeMagician() {
            return new IceMagician();
        }
    }


    public static class FireHeroFactory implements HeroFactory {

        @Override
        public Warrior makeWarrior() {
            return new FireWarrior();
        }

        @Override
        public Magician makeMagician() {
            return new FireMagician();
        }
    }
}
