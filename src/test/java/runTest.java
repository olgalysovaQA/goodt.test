import org.junit.Test;

public class runTest {

    @Test
    public void point() throws InterruptedException {
        GadgetsPage gadgets = new GadgetsPage();

        gadgets.open();
        gadgets.closeConfirmCityModal();
        gadgets.pointCategory();
        gadgets.pointSubcategory();
        gadgets.chooseItemWithLastCategory();
        gadgets.printStatistic();

    }
}
