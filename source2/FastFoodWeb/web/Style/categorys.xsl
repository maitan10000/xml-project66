<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Categorys.xsl
    Created on : October 9, 2013, 10:25 AM
    Author     : Everything
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="CategoryViews">
        <ul>
            <xsl:for-each select="CategoryView">
                <li>
                    <a href="#Action=ProductView&amp;cateID={ID}">
                        <xsl:value-of select="Name"/>
                    </a>
                </li>
            </xsl:for-each>
        </ul>
    </xsl:template>
</xsl:stylesheet>
