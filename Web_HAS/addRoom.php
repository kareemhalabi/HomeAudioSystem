<?php
require_once (__DIR__ . '\controller\Controller.php');

session_start ();

$_SESSION ["errorRoomName"] = "";
$c = new Controller ();
try {
	$room = $_POST ['roomName'];
	$volume = $_POST ['volume'];
	if ($volume == 0) {
		$c->createRoom ( $room, $volume, true );
	} else {
		$c->createRoom ( $room, $volume, false );
	}
} catch ( Exception $e ) {
	$_SESSION ["errorRoomName"] = $e->getMessage ();
}
?>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="0; url=/HAS/selectRoom.php" />
</head>
</html>