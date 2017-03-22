(define-fun is-power-of-two ((x (_ BitVec 8))) Bool 
  (= #x00 (bvand x (bvsub x #x01))))
(declare-const a (_ BitVec 8))
(assert 
 (not (= (is-power-of-two a) 
         (or (= a #x00) 
             (= a #x01) 
             (= a #x02) 
             (= a #x04) 
             ))))
(check-sat)