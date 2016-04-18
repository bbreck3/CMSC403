#lang racket

;; create an empty search tree (BST)
(define (make-empty-BST) '())
;; check if BST B is empty
(define (BST-empty? B) (null? B))
;; insert E into BST B
(define (BST-insert B E)
  (if (bin-tree-leaf? B)
      (BST-leaf-insert B E)
    (let ((elmt  (bin-tree-node-element B))
	  (left  (bin-tree-node-left    B))
	  (right (bin-tree-node-right   B)))
      (if (<= E (bin-tree-node-element B))
	  (make-bin-tree-node elmt
			      (BST-insert (bin-tree-node-left B) E)
			      right)
  	  (make-bin-tree-node elmt
			      left
			      (BST-insert (bin-tree-node-right B) E))))))