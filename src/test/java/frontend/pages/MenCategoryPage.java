package frontend.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class MenCategoryPage {

    /**
     * Локаторы для страницы MensClothesPage
     */

    protected SelenideElement textHeadingMensCategory = $x("//h1[contains(text(),'Мужчинам')]");
    protected SelenideElement buttonClothes = $x("//ul[contains(@class,'maincatalog-list-2')]//a[text()='Одежда']");

    /** Методы для тестов */

    /**
     * Сценарий №1. Проход по полному БП
     */


    @Step("Проверка отображения текстового заголовка [Мужская категория одежды]")
    public MenCategoryPage assertTextHeadingMensCategoryShouldBeVisible() {
        Assert.assertTrue((textHeadingMensCategory).shouldBe(Condition.visible).isDisplayed());
        return this;
    }

    @Step("Клик по кнопке [Одежда]")
    public MenCategoryPage clickButtonClothes() {
        (buttonClothes).shouldBe(Condition.visible).click();
        return this;
    }
}