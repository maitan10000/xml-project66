<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : orderPDF.xsl
    Created on : October 11, 2013, 1:42 PM
    Author     : Everything
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <xsl:apply-templates/>
    </xsl:template>
    <xsl:template match="OrderView">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

  <!-- defines the layout master -->
            <fo:layout-master-set>
                <fo:simple-page-master master-name="first"
                           page-height="29.7cm"
                           page-width="21cm"
                           margin-top="1cm"
                           margin-bottom="2cm"
                           margin-left="2.5cm"
                           margin-right="2.5cm">
                    <fo:region-body margin-top="3cm"/>
                    <fo:region-before extent="3cm"/>
                    <fo:region-after extent="1.5cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

  <!-- starts actual layout -->
            <fo:page-sequence master-reference="first">
                <fo:flow flow-name="xsl-region-body">

<!-- **************************** NEW PAGE ************************************* -->

      <!-- this defines a title level 2-->
                    <fo:block font-size="16pt"
            font-family="sans-serif"
            space-after.optimum="15pt"
            text-align="center"
            break-before="page">
        Order Detail
                    </fo:block>
    <!-- normal text -->

                    <fo:block text-align="start">Customer:
                        <xsl:value-of select="UserName"/>
                    </fo:block>
                    <fo:block text-align="start">Name:
                        <xsl:value-of select="FirstName"/>
                        <xsl:text> </xsl:text>
                        <xsl:value-of select="LastName"/>
                    </fo:block>
                    <fo:block text-align="start">Phone:
                        <xsl:value-of select="Phone"/>
                    </fo:block>
                    <fo:block text-align="start">Receive Address:
                        <xsl:value-of select="ReceiveAddress"/>
                    </fo:block>
                    <fo:block text-align="start">Create Date:
                        <xsl:call-template name="formatdate">
                            <xsl:with-param name="DateTimeStr" select="CreateDate"/>
                        </xsl:call-template>
                    </fo:block>
                    <fo:block text-align="start">Details:
                    </fo:block>


     <!-- table start -->
                    <fo:table table-layout="fixed" width="100%" border-collapse="separate">
                        <fo:table-column column-width="10mm"/>
                        <fo:table-column column-width="50mm"/>
                        <fo:table-column column-width="30mm"/>
                        <fo:table-column column-width="30mm"/>
                        <fo:table-column column-width="30mm"/>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell border-width="0.5pt" border-style="solid" background-color="#AFAEC2" text-align="center">
                                    <fo:block>
                                        No
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-width="0.5pt" border-style="solid" background-color="#AFAEC2" text-align="center">
                                    <fo:block>
                                        Name
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-width="0.5pt" border-style="solid" background-color="#AFAEC2" text-align="center">
                                    <fo:block>
                                        Price
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-width="0.5pt" border-style="solid" background-color="#AFAEC2" text-align="center">
                                    <fo:block>
                                       Quantity
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-width="0.5pt" border-style="solid" background-color="#AFAEC2" text-align="center">
                                    <fo:block>
                                        Total
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <xsl:for-each select="//ListOrderDetail">
                                <fo:table-row>
                                    <fo:table-cell border-width="0.5pt" border-style="solid" text-align="center" >
                                        <fo:block>
                                            <xsl:value-of select="position()"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="0.5pt" border-style="solid" padding-left="2mm">
                                        <fo:block>
                                            <xsl:value-of select="ProductName"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="0.5pt" border-style="solid" text-align="right">
                                        <fo:block>
                                            <xsl:value-of select='format-number(Price, "###,###")'/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="0.5pt" border-style="solid" text-align="center" >
                                        <fo:block>
                                            <xsl:value-of select="Quantity"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border-width="0.5pt" border-style="solid" text-align="right" >
                                        <fo:block>
                                            <xsl:value-of select='format-number(Total, "###,###")'/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                            <fo:table-row>
                                <fo:table-cell border-width="0.5pt" border-style="solid"  number-columns-spanned="4" text-align="center" >
                                    <fo:block>
                                            Total All
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-width="0.5pt" border-style="solid" text-align="right">
                                    <fo:block>
                                        <xsl:value-of select='format-number(TotalAll, "###,###")'/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
    <!-- table end -->
    <!-- End page -->
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
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
