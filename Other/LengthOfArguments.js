
/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */

let argumentsLength = (...args) => args['0'].length;

let arguments = [{}, null, "3", 1, true, [1, 2]];

// returns 6, because 6 arguments
console.log(argumentsLength(arguments));
