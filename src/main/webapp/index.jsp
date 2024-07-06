<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Grim</title>
  <style>
    body, html {
      height: 100%;
      margin: 0;
      font-family: Arial, sans-serif;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }

    #background-video {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      object-fit: cover;
      z-index: -1;
    }

    .container {
      text-align: center;
      background-color: rgba(128, 128, 128, 0.8);
      padding: 20px;
      border-radius: 10px;
      z-index: 1;
    }

    .text-container {
      background-color: rgba(128, 128, 128, 0.7);
      color: #fff;
      padding: 20px;
      border-radius: 10px;
      margin: 20px;
      width: 80%;
      max-width: 600px;
      font-size: 18px;
      line-height: 1.6;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      z-index: 1;
      position: fixed;
      bottom: 10px;
      left: 50%;
      transform: translateX(-50%);
      transition: opacity 0.3s, visibility 0.3s;
    }

    .text-container.hidden {
      opacity: 0;
      visibility: hidden;
    }

    .text-container p {
      margin: 0;
    }

    .form-buttons {
      margin: 10px;
    }

    .form-buttons button {
      padding: 10px 20px;
      font-size: 16px;
      border: none;
      border-radius: 5px;
      background-color: black;
      color: white;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .form-buttons button:hover {
      background-color: #4e4c4c;
    }

    #mute-button {
      position: fixed;
      bottom: 10px;
      right: 10px;
      z-index: 1;
      padding: 10px 20px;
      font-size: 16px;
      border: none;
      border-radius: 5px;
      background-color: black;
      color: white;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    #mute-button:hover {
      background-color: #4e4c4c;
    }

    #toggle-text-button {
      padding: 10px 20px;
      font-size: 16px;
      border: none;
      border-radius: 5px;
      background-color: black;
      color: white;
      cursor: pointer;
      transition: background-color 0.3s;
      margin-top: 10px;
    }

    #toggle-text-button:hover {
      background-color: #4e4c4c;
    }
  </style>
</head>
<body>
<video id="background-video" autoplay loop muted>
  <source src="videos/opening.mp4" type="video/mp4">
</video>
<audio id="background-audio" autoplay loop>
  <source src="audio/main.mp3" type="audio/mp3">
</audio>
<div class="container">
  <h1>Hadrian's Wall</h1>

  <form action="person-servlet" method="get" class="form-buttons">
    <button type="submit">Persons</button>
  </form>

  <form action="grim-servlet" method="get" class="form-buttons">
    <button type="submit">Grims</button>
  </form>

  <form action="creature-servlet" method="get" class="form-buttons">
    <button type="submit">Creatures</button>
  </form>
</div>

<button id="toggle-text-button" onclick="toggleText()">about HW</button>

<div class="text-container" id="text-container">
  <p>
    Hadrian's Wall, or HW, is a secret government organization that is a branch of the Federal Government opposing
    Black Claw. ("A Reptile Dysfunction") It is so secretive that most of the government doesn't know about it, as
    the organization doesn't trust a lot of people in the government. ("Wesen Nacht") They have an interest in
    recruiting Grimms in order to help support their cause, and they are extremely diligent in their efforts to
    cover up their actions or the actions of Black Claw.
  </p>
</div>

<button id="mute-button" onclick="toggleMute()">Mute</button>
<script>
  document.addEventListener('DOMContentLoaded', function () {
    var audio = document.getElementById('background-audio');
    var muteButton = document.getElementById('mute-button');
    var textContainer = document.getElementById('text-container');
    var toggleTextButton = document.getElementById('toggle-text-button');
    var hasInteracted = false;

    function playAudio() {
      if (!hasInteracted) {
        audio.play();
        hasInteracted = true;
      }
    }

    document.body.addEventListener('click', playAudio);

    window.toggleMute = function () {
      if (audio.muted) {
        audio.muted = false;
        muteButton.textContent = 'Mute';
      } else {
        audio.muted = true;
        muteButton.textContent = 'Unmute';
      }
    };

    window.toggleText = function () {
      if (textContainer.classList.contains('hidden')) {
        textContainer.classList.remove('hidden');
        toggleTextButton.textContent = 'hide Info';
      } else {
        textContainer.classList.add('hidden');
        toggleTextButton.textContent = 'about HW';
      }
    };
  });
</script>
</body>
</html>
