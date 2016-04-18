#lang racket
(require srfi/1)

;BST constructor: Creates an empty BST
(define createBST '())
(define list '())

(define test '( 1 2 4 5))
;Sample data to build the BST
(define sample '( 6 4 5 3 8 9 1 2 20 15 12 23 ))
(define rSub '())
(define root (car sample))
(define found '())
(define notInBST '())
(define mapList '())
(define sortBST '())

;createBST


;is the BST empty
(define (isEmpty lst)
  (if (null? lst) "true" "false"))
;Add value to BST
(define (addToBST v lst)
  (cond[(null? lst) (set! list (cons v lst))] 
       [(> v root) (set! rSub (cons v rSub))]
       [(< v root) (set! list  (cons v lst))]))

;Search BST
(define (searchBST BST v)
 (if(member v list) (set! found (cons (list-ref list (list-index (curry equal? v) list)) found)) (set! notInBST (cons v notInBST ))))

;MAP BST
(define (mapBST BST )
  (set!  mapList (append BST mapList)))

(define (foldBST BST)
  (set! sortBST (sort BST <)))



(for ([e (in-list sample)])
  ( addToBST  e list)
  ;(displayln e)
  );
(set! list (append list rSub))

(searchBST list 0)
(mapBST list )
(foldBST list)
list

found
sortBST





 






     