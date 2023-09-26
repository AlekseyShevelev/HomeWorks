public class GoldGenerator extends ItemFabric{
    @Override
    public iGameItem createItem() {
        System.out.println("Создал новый сундук");
        return new GoldReward();
    }
}
