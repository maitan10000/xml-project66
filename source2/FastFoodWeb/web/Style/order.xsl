<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : order.xsl
    Created on : October 10, 2013, 11:25 PM
    Author     : Everything
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="OrderView">
        <h1>Order Detail</h1>
        Customer:
        <xsl:value-of select="UserName"/>
        <br/>
            Name:
        <xsl:value-of select="FirstName"/>
        <xsl:value-of select="LastName"/>
        <br/>
        Phone:
        <xsl:value-of select="Phone"/>
        <br/>
        Receive Address:
        <xsl:value-of select="ReceiveAddress"/>

        <br/>
        Create Date:
        <xsl:value-of select="CreateDate"/>
        <br/>
        <b>Details:</b>
        <br/>
        <table border="1">
            <tr>
                <th>No</th>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>
            <xsl:for-each select="//ListOrderDetail">
                <tr>
                    <td>
                        <xsl:value-of select="position()" />
                    </td>
                    <td>
                        <xsl:value-of select="ProductName"/>
                    </td>
                    <td>
                        <xsl:value-of select="Price"/>
                    </td>
                    <td>
                        <xsl:value-of select="Quantity"/>
                    </td>
                    <td>
                        <xsl:value-of select="Total"/>
                    </td>
                </tr>
            </xsl:for-each>
            <tr>
                <td colspan="4">
                    Total All:
                </td>
                <td>
                    <xsl:value-of select="TotalAll"/>
                </td>
            </tr>
        </table>
    </xsl:template>
</xsl:stylesheet>
