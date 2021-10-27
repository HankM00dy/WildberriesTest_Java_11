package frontend.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    /**
     * Локаторы для страницы CatalogPage
     */

    protected SelenideElement buttonCostumes = $x("//a[text()='Костюмы']");
    protected ElementsCollection imageOfItem = elements(By.xpath("//div[contains(@class,'product-card__img-wrap')]//img"));
    protected SelenideElement checkboxSportCostume = $x("//label[contains(text(),'Костюм спортивный')]");
    protected SelenideElement inputBrandSearch = $x("//div[contains(@data-filter-name,'fbrand')]//input[contains(@class,'j-search-filter')]");
    protected SelenideElement buttonSortByPrice = $x("//a[contains(text(),'цене')]");
    protected SelenideElement checkboxSneakers = $x("//label[contains(text(),'Кроссовки')]");
    protected SelenideElement buttonSneakersSection = $x("//li[contains(@class,'selected')]//a[contains(text(),'Кеды и кроссовки')]");

    /** Методы для тестов */

    /**
     * Сценарий №1. Проход по полному БП
     */

    @Step("Клик по кнопке [Костюмы]")
    public CatalogPage clickButtonCostumes() {
        (buttonCostumes).shouldBe(visible).click();
        return this;
    }

    @Step("Проверка отображения изображений товаров")
    public CatalogPage assertImageOfItemShouldBeVisible() {
        (imageOfItem).shouldHave(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    @Step("Клик по чекбоксу [Спортивные костюмы]")
    public CatalogPage clickCheckboxSportCostume() {
        (checkboxSportCostume).shouldBe(visible).click();
        return this;
    }

    @Step("Проверка выделения чекбокса")
    public CatalogPage assertCheckboxShouldBeSelected(String valueOfTextInCheckboxLabel) {
        SelenideElement checkbox = $x("//label[contains(@class,'selected')][contains(text(),'" + valueOfTextInCheckboxLabel + "')]");
        (checkbox).shouldBe(visible).isDisplayed();
        return this;
    }

    @Step("Ввод значения в поле [Бренд]")
    public CatalogPage setInputBrandSearch(String textValue) {
        (inputBrandSearch).shouldBe(visible).setValue(textValue);
        return this;
    }

    @Step("Клик по чекбоксу [Бренд]")
    public CatalogPage clickCheckboxBrand(String brandName) {
        SelenideElement checkboxBrand = $x("//label[contains(text(),'" + brandName + "')]");
        (checkboxBrand).shouldBe(visible).click();
        return this;
    }

    @Step("Клик по чекбоксу [Сортировка по цене]")
    public CatalogPage clickButtonSortByPrice() {
        (buttonSortByPrice).shouldBe(visible).click();
        return this;
    }

    @Step("Клик по изображению товара в каталоге по индексу")
    public CatalogPage clickImageProductInCatalog(int index) {
        ElementsCollection imageProductInCatalog = $$x("//div[contains(@class,'product-card__img-wrap')]//img");
        imageProductInCatalog.shouldBe(CollectionCondition.sizeGreaterThan(0));
        Selenide.actions()
                .moveToElement(imageProductInCatalog.get(index), 0, -30)
                .click()
                .build()
                .perform();
        return this;
    }

    @Step("Клик по кнопке [Кроссовки]")
    public CatalogPage clickButtonSneakersSection() {
        (buttonSneakersSection).shouldBe(visible).click();
        return this;
    }

    @Step("Клик по чекбоксу [Кроссовки]")
    public CatalogPage clickCheckboxSneakers() {
        (checkboxSneakers).shouldBe(visible).click();
        return this;
    }
}
