/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
  return s.trim().split(' ')[(s.trim().split(' ')).length-1];
};

/* Tests */
console.log(lengthOfLastWord("Hello World"));
console.log(lengthOfLastWord("  fly me    to the  moon  "));
console.log(lengthOfLastWord("luffy is still joyboy"));
