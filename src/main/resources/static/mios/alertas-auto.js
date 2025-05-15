// alertas-auto.js (versión con soporte para data-delay)
class AutoCloseAlert {
  constructor(selector, segundosPorDefecto = 3) {
    this.alerts = document.querySelectorAll(selector);
    this.defaultDelay = segundosPorDefecto * 1000;
    this.init();
  }

  init() {
    this.alerts.forEach(alert => {
      const segundos = alert.dataset.delay ? parseInt(alert.dataset.delay) : this.defaultDelay / 1000;
      const delay = segundos * 1000;

      setTimeout(() => {
        alert.classList.add("fade");
        alert.classList.remove("show");
        setTimeout(() => alert.remove(), 300);
      }, delay);
    });
  }
}

document.addEventListener("DOMContentLoaded", function () {
  new AutoCloseAlert(".alert.auto-close", 5); // tiempo por defecto: 5 segundos
});