/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.es.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author shinnlove.jinsheng
 * @version $Id: IFFOrder.java, v 0.1 2019-11-16 10:04 下午 shinnlove.jinsheng Exp $$
 */
@Document(indexName = "iff", type = "order")
public class IFFOrder implements Serializable {

    private static final long serialVersionUID = 5312764403798189742L;

    @Id
    private Long              id;

    @Field(type = FieldType.Keyword)
    private String            cartId;

    @Field(type = FieldType.Keyword)
    private String            vendor;

    @Field(type = FieldType.Keyword)
    private String            transactionId;

    @Field(type = FieldType.Keyword)
    private String            fundingStatus;

    @Field(type = FieldType.Integer)
    private int               isPrimaryOrder;

    @Field(type = FieldType.Double)
    private double            price;

    @Field(type = FieldType.Keyword)
    private String            message;

    @Field(type = FieldType.Text)
    private String            payloads;

    public IFFOrder() {
    }

    public IFFOrder(Long id, String cartId, String vendor, String transactionId,
                    String fundingStatus, int isPrimaryOrder, double price, String message,
                    String payloads) {
        this.id = id;
        this.cartId = cartId;
        this.vendor = vendor;
        this.transactionId = transactionId;
        this.fundingStatus = fundingStatus;
        this.isPrimaryOrder = isPrimaryOrder;
        this.price = price;
        this.message = message;
        this.payloads = payloads;
    }

    /**
     * Getter method for property id.
     *
     * @return property value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for property cartId.
     *
     * @return property value of cartId
     */
    public String getCartId() {
        return cartId;
    }

    /**
     * Setter method for property cartId.
     *
     * @param cartId value to be assigned to property cartId
     */
    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    /**
     * Getter method for property vendor.
     *
     * @return property value of vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * Setter method for property vendor.
     *
     * @param vendor value to be assigned to property vendor
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * Getter method for property transactionId.
     *
     * @return property value of transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Setter method for property transactionId.
     *
     * @param transactionId value to be assigned to property transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Getter method for property fundingStatus.
     *
     * @return property value of fundingStatus
     */
    public String getFundingStatus() {
        return fundingStatus;
    }

    /**
     * Setter method for property fundingStatus.
     *
     * @param fundingStatus value to be assigned to property fundingStatus
     */
    public void setFundingStatus(String fundingStatus) {
        this.fundingStatus = fundingStatus;
    }

    /**
     * Getter method for property isPrimaryOrder.
     *
     * @return property value of isPrimaryOrder
     */
    public int getIsPrimaryOrder() {
        return isPrimaryOrder;
    }

    /**
     * Setter method for property isPrimaryOrder.
     *
     * @param isPrimaryOrder value to be assigned to property isPrimaryOrder
     */
    public void setIsPrimaryOrder(int isPrimaryOrder) {
        this.isPrimaryOrder = isPrimaryOrder;
    }

    /**
     * Getter method for property price.
     *
     * @return property value of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter method for property price.
     *
     * @param price value to be assigned to property price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter method for property message.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property message.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method for property payloads.
     *
     * @return property value of payloads
     */
    public String getPayloads() {
        return payloads;
    }

    /**
     * Setter method for property payloads.
     *
     * @param payloads value to be assigned to property payloads
     */
    public void setPayloads(String payloads) {
        this.payloads = payloads;
    }

}