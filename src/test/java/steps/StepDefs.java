package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.OzonCatalogPage;
import pages.OzonMainPage;

public class StepDefs {

    @Когда("пользователь выбирает категорию товара {string}")
    public void пользовательВыбираетКатегориюТовара(String name) {
        OzonMainPage page = new OzonMainPage();
        page.openCategory(name);
    }

    @И("выбирает бренд {string}")
    public void выбираетБренд(String name) {
        OzonCatalogPage page = new OzonCatalogPage();
        page.selectBrand(name);
    }

    @Тогда("отображаются товары выбранного бренда {string}")
    public void отображаютсяТоварыВыбранногоБренда(String name) {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkActiveFilterByBrand(name);
    }

    @Тогда("отображается сообщение о том, что бренд не найден")
    public void отображаетсяСообщениеОТомЧтоБрендНеНайден() {
        OzonCatalogPage page = new OzonCatalogPage();
        page.checkBrandIsNotFound();
    }
}
