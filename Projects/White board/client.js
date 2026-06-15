document.addEventListener('DOMContentLoaded', () => {
    const socket = io();

    // Canvas and Chat Elements
    const canvas = document.getElementById('drawing-canvas');
    const ctx = canvas.getContext('2d');
    const chatForm = document.getElementById('chat-input');
    const messages = document.getElementById('messages');
    const messageInput = document.getElementById('message');

    // Toolbar Actions
    const themeToggle = document.getElementById('theme-toggle');
    themeToggle.addEventListener('click', () => {
        document.body.classList.toggle('dark-theme');
    });

    // Handle Drawing
    // Add events for drawing, eraser, and clear canvas
});

