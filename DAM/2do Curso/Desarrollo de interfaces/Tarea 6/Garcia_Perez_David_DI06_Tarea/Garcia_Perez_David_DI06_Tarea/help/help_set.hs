<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE helpset PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN" "http://java.sun.com/products/javahelp/helpset_1_0.dtd">
<helpset version="1.0">
    <title>Sistema de Ayuda con JavaHelp</title>
    <maps>
        <homeID>introduccion</homeID>
        <mapref location="map_file.jhm"/>
    </maps>
    <view>
        <name>Tabla de Contenidos</name>
        <label>Tabla de Contenidos</label>
        <type>javax.help.TOCView</type>
        <data>toc.xml</data>
    </view>
    <view>
        <name>Index</name>
        <label>Índice</label>
        <type>javax.help.IndexView</type>
        <data>index.xml</data>
    </view>
    <view>
        <name>Buscar</name>
        <label>Buscar</label>
        <type>javax.help.SearchView</type>
        <data engine="com.sun.java.help.search.DefaultSearchEngine">JavaHelpSearch</data>
    </view>
</helpset>