package net.javawookies.laundryShop.repository;

import net.javawookies.laundryShop.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegisterUser, Long> {
}
