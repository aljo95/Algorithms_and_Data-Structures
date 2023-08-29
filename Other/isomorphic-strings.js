
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */

let isIsomorphic = (s, t) => {
    const map1 = new Map();
    const map2 = new Map();

    for (let i=0; i<s.length; i++) {
        if(map1.get(s[i]) !== map2.get(t[i]))  return false;
        map1.set(s[i], i+1);
        map2.set(t[i], i+1);
    }
    return true;
};

let s = "egg";
let t = "add";
console.log(isIsomorphic(s, t));    // true

s = "foo";
t = "bar";
console.log(isIsomorphic(s, t));    // false

s = "paper";
t = "title";
console.log(isIsomorphic(s, t));    // true
