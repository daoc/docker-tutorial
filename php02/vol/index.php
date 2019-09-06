<!DOCTYPE html>
<html>
	<head>
		<title>Tarea01</title>
	</head>
	<body>

		<h3>Tarea01</h3>
		
		<?php
		$animal['Cebra'] = 'cebra.JPG';
		$animal['Liebre'] = 'liebre.JPG';
		$animal['Mapache'] = 'mapache.JPG';
		$animal['Oso'] = 'oso.JPG';
		$animal['Rinoceronte'] = 'rinoceronte.JPG';
		$animal['Tigre'] = 'tigre.JPG';
		
		echo "<table border='1'>";
		foreach($animal as $clave => $valor) {
		  echo "<tr><td>" . $clave . "</td>";
		  echo "<td><img src='" . $valor . "'/></td></tr>";
		}
		echo "</table>";
		?>

	</body>
</html>