package com.uphold.uphold_android_sdk.model.transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Origin model.
 */

public class Origin implements Serializable {

    private final String AccountId;
    private final String CardId;
    private final String accountType;
    private final String amount;
    private final String base;
    private final String commission;
    private final String currency;
    private final String description;
    private final String fee;
    private final Merchant merchant;
    private final Node node;
    private final String rate;
    private final List<Source> sources;
    private final String type;
    private final String username;

    /**
     * Constructor.
     *
     * @param AccountId The id of the account from the origin of the transaction.
     * @param cardId The card id of the card from the origin of the transaction.
     * @param accountType The type of the account from the origin of the transaction.
     * @param amount The amount from the origin of the transaction.
     * @param base The base from the origin of the transaction.
     * @param commission The commission from the origin of the transaction.
     * @param currency The currency from the origin of the transaction.
     * @param description The description from the origin of the transaction.
     * @param fee The fee from the origin of the transaction.
     * @param merchant The merchant from the origin of the transaction.
     * @param node The node from the origin of the transaction.
     * @param rate The rate from the origin of the transaction.
     * @param sources The sources from the origin of the transaction.
     * @param type The type from the origin of the transaction.
     * @param username The username from the origin of the transaction.
     */

    public Origin(String AccountId, String cardId, String accountType, String amount, String base, String commission, String currency, String description, String fee, Merchant merchant, Node node, String rate, List<Source> sources, String type, String username) {
        this.AccountId = AccountId;
        this.CardId = cardId;
        this.accountType = accountType;
        this.amount = amount;
        this.base = base;
        this.commission = commission;
        this.currency = currency;
        this.description = description;
        this.fee = fee;
        this.merchant = merchant;
        this.node = node;
        this.rate = rate;
        this.sources = sources;
        this.type = type;
        this.username = username;
    }

    /**
     * Gets the id of the account from the origin of the transaction.
     *
     * @return the id of the account from the origin of the transaction.
     */

    public String getAccountId() {
        return AccountId;
    }

    /**
     * Gets the card id of the card from the origin of the transaction.
     *
     * @return the id of the card from the origin of the transaction.
     */

    public String getCardId() {
        return CardId;
    }

    /**
     * Gets the type of the account from the origin of the transaction
     *
     * @return the type of the account.
     */

    public String getAccountType() {
        return accountType;
    }

    /**
     * Gets the amount from the origin of the transaction.
     *
     * @return the amount from the origin of the transaction.
     */

    public String getAmount() {
        return amount;
    }

    /**
     * Gets the base from the origin of the transaction.
     *
     * @return the base from the origin of the transaction.
     */

    public String getBase() {
        return base;
    }

    /**
     * Gets the commission from the origin of the transaction.
     *
     * @return the commission from the origin of the transaction.
     */

    public String getCommission() {
        return commission;
    }

    /**
     * Gets the currency from the origin of the transaction.
     *
     * @return the currency from the origin of the transaction.
     */

    public String getCurrency() {
        return currency;
    }

    /**
     * Gets the description from the origin of the transaction.
     *
     * @return the description from the origin of the transaction.
     */

    public String getDescription() {
        return description;
    }

    /**
     * Gets the fee from the origin of the transaction.
     *
     * @return the fee from the origin of the transaction.
     */

    public String getFee() {
        return fee;
    }

    /**
     * Gets the merchant from the origin of the transaction.
     *
     * @return the merchant from the origin of the transaction.
     */

    public Merchant getMerchant() {
        return merchant;
    }

    /**
     * Gets the node from the origin of the transaction.
     *
     * @return the node from the origin of the transaction.
     */

    public Node getNode() {
        return node;
    }

    /**
     * Gets the rate from the origin of the transaction.
     *
     * @return the rate from the origin of the transaction.
     */

    public String getRate() {
        return rate;
    }

    /**
     * Gets the list of the sources from the origin of the transaction.
     *
     * @return the list of sources from the origin of the transaction.
     */

    public List<Source> getSources() {
        return sources;
    }

    /**
     * Gets the type from the origin of the transaction.
     *
     * @return the type from the origin of the transaction.
     */

    public String getType() {
        return type;
    }

    /**
     * Gets the username from the origin of the transaction.
     *
     * @return the username from the origin of the transaction.
     */

    public String getUsername() {
        return username;
    }

}
