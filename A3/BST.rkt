#lang racket


(define (test)
  (list '()))
;BST constructor: Creates an empty BST
(define createBST '())
(define list '())
;Sample data to build the BST
(define sample '( 6 4 5 3 8 9 ))    
;createBST


;is the BST empty
(define (isEmpty lst)
  (if (null? lst) "true" "false"))

(define (insert v)
  (if (isEmpty lst) (set! list v) ""))

(insert (car sample))
     






;(if(isEmpty list) (set! list (car sample)) "not")
;(displayln list)

(set! sample (remove (car sample) sample))
(displayln sample)
(displayln list)


(define temp (car sample))
(define var list)
(if( < temp var) (cons temp list) "")(displayln  list)
(if ( > temp var)  (cons temp list) "")(displayln  list)
