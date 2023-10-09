/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
/*
var argumentsLength = function(...args) {

    let count = 0;
    for (let i=0; i<args['0'].length; i++) {
        count++;
    }
    return count;
};
*/

let argumentsLength2 = (...args) => args['0'].length;


args1 = [{}, null, "3", 1, true, [1, 2]];
console.log(argumentsLength2(args1));



/**
 * argumentsLength(1, 2, 3); // 3
 */