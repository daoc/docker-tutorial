<!DOCTYPE html>
<html>
    <head>
        <title>Docker, tutorial: php01</title>
    </head>
    <body>
        <h2>
            <?php
                if(isset($_GET['C'])) {
                    echo "C= " . $_GET['C'];
                } else {
                    echo 'NO hay $_GET["C"]';
                }
            ?>
        </h2>
    </body>
</html>
