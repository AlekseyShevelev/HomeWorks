public class GemGenerator extends ItemFabric {
    @Override
    public iGameItem createItem() {
        System.out.println("Создал новый сундук");
        return new GemReward();
    }
}
