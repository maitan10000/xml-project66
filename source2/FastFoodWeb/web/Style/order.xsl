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
        <xsl:call-template name="formatdate">
            <xsl:with-param name="DateTimeStr" select="CreateDate"/>
        </xsl:call-template>
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
                        <xsl:value-of select='format-number(Price, "###,###")'/>
                    </td>
                    <td>
                        <xsl:value-of select="Quantity"/>
                    </td>
                    <td>
                        <xsl:value-of select='format-number(Total, "###,###")'/>
                    </td>
                </tr>
            </xsl:for-each>
            <tr>
                <td colspan="4">
                    Total All:
                </td>
                <td>
                    <xsl:value-of select='format-number(TotalAll, "###,###")'/>
                </td>
            </tr>
        </table>
    </xsl:template>
    <xsl:template name="formatdate">
        <xsl:param name="DateTimeStr" />
        <xsl:variable name="datestr">
            <xsl:value-of select="substring-before($DateTimeStr,'T')" />
        </xsl:variable>

        <xsl:variable name="mm">
            <xsl:value-of select="substring($datestr,6,2)" />
        </xsl:variable>

        <xsl:variable name="dd">
            <xsl:value-of select="substring($datestr,9,2)" />
        </xsl:variable>

        <xsl:variable name="yyyy">
            <xsl:value-of select="substring($datestr,1,4)" />
        </xsl:variable>

        <xsl:value-of select="concat($dd,'/', $mm, '/', $yyyy)" />
    </xsl:template>
</xsl:stylesheet>
