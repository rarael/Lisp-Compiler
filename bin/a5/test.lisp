(cons 2 3)
(cons 5 nil)
(list 1 2)
(list (cond ((+ 1 2) 2)) nil)
(eval (quote (<= 5 6)))
(eval (or 1 nil))
(cond ((+ 1 2) 2) (nil 6) (T 7) ((not nil) 5))
(quote (<= 4 100))
(cond (T))
(cond ((not nil) 5))
(cond ((not T) nil))
(cond (nil 6) (nil 1) ((+ 1 3) 2))
(cond (nil 8) (T 5) ((+ 4 5) 3))
(cond ((not T) nil) ((not nil) T) ((not T) T))
(> 1 2)
(> 4 2)
(< 5 6)
(< 9 7)
(>= 2 2)
(>= 9 10)
(<= 1 1)
(or 5 6)
(not T)
(not nil)
(and 1 2)
(and nil 2)
(and 3 4)
