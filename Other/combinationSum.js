/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {

  let indx = 0;
  let temp = [];
  let finalResult = [];

  let backtracking = (indx, target, temp) => {
    if (target === 0) {
      finalResult.push([...temp]);
      return;
    }
    if (target < 0) return;

    for (let i=indx; i<candidates.length; i++) {
      temp.push(candidates[i]);
      backtracking(i, target-candidates[i], temp);
      temp.pop();
    }
  }

  backtracking(indx, target, temp);
  return finalResult;
};

let test1 = [2, 3, 6, 7];
let t1 = 7;
let res = combinationSum(test1, t1);
console.log(res);

let test2 = [2, 3, 5];
let t2 = 8;
let res2 = combinationSum(test2, t2);
console.log(res2);

