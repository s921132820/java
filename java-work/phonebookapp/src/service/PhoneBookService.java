package service;

import dto.TelBookDTO;
import repository.PhoneBookRepository;

import java.util.List;

public class PhoneBookService implements ServiceInterface{
    PhoneBookRepository bookRepository = new PhoneBookRepository();

    @Override
    public int inserService(TelBookDTO dto) {
        System.out.println("[PhoneBookService]-insertService");
        return bookRepository.inserData(dto);
    }

    @Override
    public int updateService(TelBookDTO dto) {
        System.out.println("[PhoneBookService]-updateService");
        return bookRepository.updateData(dto);
    }

    @Override
    public int deleteService(long id) {
        System.out.println("[PhoneBookService]-deleteService");
        return bookRepository.deleteDate(id);
    }

    @Override
    public List<TelBookDTO> getAllListService() {
        System.out.println("[PhoneBookService]-getAllListService");
        return bookRepository.getAllList();
    }

    @Override
    public TelBookDTO findByIdService(Long id) {
        System.out.println("[PhoneBookService]-findByIdService");
        return bookRepository.findById(id);
    }

    @Override
    public List<TelBookDTO> findByNameService(String name) {
        System.out.println("[PhoneBookService]-findByNameService");
        return List.of();
    }

    @Override
    public List<TelBookDTO> findByPhoneService(String phone) {
        System.out.println("[PhoneBookService]-findByPhoneService");
        return List.of();
    }
}
