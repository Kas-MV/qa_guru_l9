package guru.qa.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MotoPage {

    /**Название категории*/
    public final ElementsCollection motoVehicleCategory = $$(".category");

    /**Главное меню категорий*/
    public final ElementsCollection menuButton = $$(".root-item");

    /**Описание категории*/
    public final SelenideElement title = $(".ch_title");

}
