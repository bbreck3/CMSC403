#lang racket
(require srfi/1)
;CMSC403: Pogramming Languages
;A3: Lisp BST
;Robert Breckenridge
;V00637965



;All Procedures: With simply one number: if you run the testRun method at the bottum, it will be more clear the methods
;constructBST ->'()
;(addToBST constructBST 3 3) --> '(3)
;(searchBST constructBST 3) --> (3)
;(searchBST constructBST 100) -->   ; value not in the BST will not display

;(mapBST constructBST) --> (3)
;(foldBST constructBST) --> (3)
;BST constructor: Creates an empty BST
(define constructBST '())
(define list '())


;Sample data to build the BST
(define sample '( 6 4 5 3 8 9 1 2 20 15 12 23 ))
(define rSub '())
(define root (car sample))
(define found '())
(define notInBST '())
(define mapList '())
(define sortBST '())
(define test '( 1 2 4 5))

 
;is the BST empty
(define (isEmpty lst)
  (if (null? lst) "true" "false"))
;Add value to BST
(define (addToBST lst v k)
  (cond[(null? lst) (set! constructBST (cons v lst))]  ; if the BST is null, add the value to root
       [(> v root) (set! rSub (cons v rSub))] ;; if the value is greater than the root add the value to the Right SubTree
       [(< v root) (set! constructBST  (cons v lst))])); if the value less than the root add the the value to constructBST left of root...functionaly acts as the left subtree

;Search BST
(define (searchBST BST v)
(if(member v constructBST) (displayln v) (displayln " ")));(set! found (cons (list-ref createBST (list-index (curry equal? v) createBST)) found)) (set! notInBST (cons v notInBST )))
;(if(member v createBST) (displayln found) (displayln notInBST))) 



;MAP BST
(define (mapBST BST )
  (set!  mapList (append BST mapList)) ;maps the BST to a new BST
  (displayln mapList))
;Fold BST
(define (foldBST BST)
  (set! sortBST (sort BST <)) ;sort the BST in ascending order
        (displayln sortBST))

;Test run to load some test data into the BST
(define (testRun)
(for ([e (in-list sample)])
  ( addToBST constructBST e e)
  ;(displayln e)
  )
(set! constructBST (append constructBST rSub))
  )

;Show the contents of the list
(define (show)
  (set! constructBST (append constructBST rSub))
  (displayln constructBST))







 






     