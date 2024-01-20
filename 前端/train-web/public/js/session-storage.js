// 所有的session key都在这里统一定义，可以避免多个功能使用同一个key
const SESSION_ORDER = 'SESSION_ORDER';
const SESSION_TICKET_PARAMS = 'SESSION_TICKET_PARAMS';

const SessionStorage = {
  get: function (key) {
    const v = sessionStorage.getItem(key);
    if (v && typeof v !== 'undefined' && v !== 'undefined') {
      return JSON.parse(v);
    }
  },
  set: function (key, data) {
    sessionStorage.setItem(key, JSON.stringify(data));
  },
  remove: function (key) {
    sessionStorage.removeItem(key);
  },
  clearAll: function () {
    sessionStorage.clear();
  },
};

window.SESSION_ORDER = SESSION_ORDER;
window.SESSION_TICKET_PARAMS = SESSION_TICKET_PARAMS;
window.SessionStorage = SessionStorage;
