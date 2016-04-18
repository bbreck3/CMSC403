#lang racket

;BST constructor: Creates an empty BST
(define createBST '())
(define list '())

(define test '( 1 2 4 5))
;Sample data to build the BST
(define sample '( 6 4 5 3 8 9 ))    
;createBST


;is the BST empty
(define (isEmpty lst)
  (if (null? lst) "true" "false"))

(define (insert v lst)
  (cond [(isEmpty lst) (display "list is empty")];(set! lst v)]
       [(> v lst) ("v > lst")];(set! list v)] ;(set! list v) "")
       [(< v lst) ("v < lst")]));(cons list v)]))
         




(set! test (car sample))
 test

                  
;(insert (car sample) list)
;list



;(for ([e (in-list sample)])
 ; ( insert e list)
  ;(displayln e))
  ;)





     