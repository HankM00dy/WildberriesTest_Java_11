package frontend.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.element;

public class MainPage {

    /**
     * Локаторы для страницы MainPage
     */

    protected SelenideElement inputMainSearchLine = element(By.xpath("//input[contains(@class,'search-catalog__input')]"));
    protected SelenideElement buttonNavigation = element(By.xpath("//button[contains(@aria-label,'Навигация по сайту')]"));
    protected SelenideElement buttonMensCategory = element(By.xpath("//li[contains(@class,'menu-burger__main-list-item')]//a[contains(text(),'Мужчинам')]"));
    protected SelenideElement buttonShoesCategory = element(By.xpath("//li[contains(@class,'menu-burger__main-list-item')]//a[contains(text(),'Обувь')]"));

    /** Методы для тестов */

    /**
     * Сценарий №1. Проход по полному БП
     */

    @Step("Проверка, что строка поиска на главной строке отображается")
    public MainPage assertInputMainSearchLineShouldBeVisible() {
        Assert.assertTrue((inputMainSearchLine).shouldBe(Condition.visible).isDisplayed());
        return this;
    }

    @Step("Клик по кнопке [Навигация]")
    public MainPage clickButtonNavigation() {
        (buttonNavigation).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Клик по кнопке [Мужская одежда]")
    public MainPage clickButtonMensCategory() {
        (buttonMensCategory).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Клик по кнопке [Обувь]")
    public MainPage clickButtonShoesCategory() {
        (buttonShoesCategory).shouldBe(Condition.visible).click();
        return this;
    }
}