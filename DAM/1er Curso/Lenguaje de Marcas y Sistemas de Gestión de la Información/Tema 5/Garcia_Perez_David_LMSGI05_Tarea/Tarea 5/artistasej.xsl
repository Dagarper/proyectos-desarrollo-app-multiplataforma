<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/">
	<html>
		<head>
			<meta charset="UTF-8" />
			<title>Tabla de Artistas</title>
		</head>
		<body>
			<table>
				<tr>
					<th>Código</th>
					<th>Nombre</th>
					<th>Año de nacimiento</th>
					<th>Año de fallecimiento</th>
					<th>País</th>
					<th>Página web</th>
      			</tr>
				<xsl:for-each select="artistas/artista">
				<xsl:sort select="nacimiento" order="ascending"></xsl:sort>
				<xsl:if test="nacimiento &gt; 1500">
				<tr>
					<td>
						<xsl:value-of select="@cod" />
					</td>
					<td>
						<xsl:value-of select="nombreCompleto" />
					</td>
					<td>
						<xsl:value-of select="nacimiento" />
					</td>
					<td>
						<xsl:choose>
							<xsl:when test="fallecimiento">
								<xsl:value-of select="fallecimiento"/>
							</xsl:when>
							<xsl:otherwise>Desconocido</xsl:otherwise>
						</xsl:choose>
					</td>
					<td>
						<xsl:value-of select="pais" />
					</td>
					<td>
						<a>
							<xsl:attribute name="href">
								<xsl:value-of select="fichaCompleta" />
							</xsl:attribute>
							Saber más
						</a>
					</td>
				</tr>
				</xsl:if>
				</xsl:for-each>
			</table>
		</body>	
	</html>
	</xsl:template>
</xsl:stylesheet>