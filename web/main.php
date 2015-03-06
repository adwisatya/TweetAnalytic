<?php
//Flush (send) the output buffer and turn off output buffering
while (ob_get_level() > 0)
    ob_end_flush();

echo "Hello!";

for($i = 0; $i < 10; $i ++) {
    echo $i . "\r\n";
}

?>