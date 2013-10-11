<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : products.xsl
    Created on : October 9, 2013, 12:41 PM
    Author     : Everything
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:param name="cateIDIn" />
    <xsl:template match="/">
        <xsl:apply-templates select="ProductViews" />
    </xsl:template>
    <xsl:template match="ProductViews">
        <ul>
            <xsl:for-each select="ProductView[CateID=$cateIDIn]">
                <li>
                    <div id="{ID}" class="product">
                        <a href="#Action=ProductDetail&amp;ID={ID}">
                            <img src="http://placehold.it/170x170" class="productImage"/>
                        </a>
                        <h4>
                            <xsl:value-of select="Name"/>
                        </h4>
                        <span>Price:
                            <xsl:value-of select="Price"/> VND
                        </span>
                    </div>
                </li>
            </xsl:for-each>
        </ul>
    </xsl:template>
</xsl:stylesheet>
