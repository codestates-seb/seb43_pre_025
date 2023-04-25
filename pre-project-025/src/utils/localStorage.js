export const getLocalStorage = () => {
<<<<<<< HEAD
    return JSON.parse(localStorage.getItem('user'));
  };
  
  export const addLocalStorage = (payload) => {
    return localStorage.setItem('user', JSON.stringify(payload));
  };
  
  export const removeLocalStroage = () => {
    return localStorage.removeItem('user');
  };
  
=======
  return JSON.parse(localStorage.getItem("user"));
};

export const addLocalStorage = (payload) => {
  return localStorage.setItem("user", JSON.stringify(payload));
};

export const removeLocalStroage = () => {
  return localStorage.removeItem("user");
};
>>>>>>> 99126425ee1616c82a963923ebd79e57f0d9d5d4
