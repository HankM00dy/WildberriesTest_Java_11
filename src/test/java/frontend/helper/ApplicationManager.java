package frontend.helper;

import frontend.pages.*;

public class ApplicationManager {

    public CardOfProductPage cardOfProductPage;
    public CartPage cartPage;
    public CatalogPage catalogPage;
    public LoginPage loginPage;
    public MainPage mainPage;
    public MenCategoryPage menCategoryPage;
    public ShoesCategoryPage shoesCategoryPage;

    public ApplicationManager() {
        cardOfProductPage = PageBuilder.buildCardOfProductPage();
        cartPage = PageBuilder.buildCartPage();
        catalogPage = PageBuilder.buildCatalogPage();
        loginPage = PageBuilder.buildLoginPage();
        mainPage = PageBuilder.buildMainPage();
        menCategoryPage = PageBuilder.buildMenCategoryPage();
        shoesCategoryPage = PageBuilder.buildShoesCategoryPage();
    }
}