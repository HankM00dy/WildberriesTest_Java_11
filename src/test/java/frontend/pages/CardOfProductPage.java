package frontend.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class CardOfProductPage {

    /**
     * Локаторы для страницы CardOProductPage
     */

    protected SelenideElement imageOFProduct = $x("//img[contains(@class,'photo-zoom__preview')]");
    protected SelenideElement buttonAddToCart = $x("//button[contains(text(),'Добавить в корзину')]");
    protected SelenideElement buttonGoToCart = $x("//a[contains(text(),'Перейти в корзину')]");
    protected SelenideElement buttonTurnBack = $x("//a[contains(text(),'Назад')]");
    protected SelenideElement textNameOfProduct = $x("//span[contains(@data-link,'text{:productCard^goodsName}')]");

    /** Методы для тестов */

    /**
     * Сценарий №1. Проход по полному БП
     */

    @Step("Проверка отображения изображения товара в карточке товара")
    public CardOfProductPage assertImageOFProductShouldBeVisible() {
        (imageOFProduct).shouldBe(Condition.visible).scrollTo().exists();
        return this;
    }

    @Step("Клик по кнопке [Размер] по индексу")
    public CardOfProductPage clickButtonSizeOfProduct(String numberOfSize) {
        ElementsCollection buttonSizeOfProduct = $$x("//li[contains(@class,'sizes-list__item')]//label[not(contains(@class,'disabled'))]");
        (buttonSizeOfProduct).get(0).click();
        return this;
    }

    @Step("Клик по кнопке [Добавить в корзину]")
    public CardOfProductPage clickButtonAddToCart() {
        textNameOfProduct.scrollTo();
        actions().moveToElement(textNameOfProduct);
        (buttonAddToCart).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Проверка отображения кнопки [Перейти в корзину]")
    public CardOfProductPage assertButtonGoToCartShouldBeVisible() {
        (buttonGoToCart).shouldBe(Condition.visible).isDisplayed();
        return this;
    }

    @Step("Получить название продукта")
    public String getTextNameOfProduct() {
        String nameOfProduct = (textNameOfProduct).shouldBe(Condition.visible).getOwnText();
        return nameOfProduct;
    }

    @Step("Клик по кнопке [Назад]")
    public CardOfProductPage clickButtonTurnBack() {
        (buttonTurnBack).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Клик по кнопке [Перейти в корзину]")
    public CardOfProductPage clickButtonGoToCart() {
        (buttonGoToCart).shouldBe(Condition.visible).click();
        return this;
    }
}